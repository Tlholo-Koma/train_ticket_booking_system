USE [AllAboard]
GO

-- Inserting stations
MERGE [Station] AS TARGET 
USING (VALUES
	  ('Hatfield'),
	  ('Pretoria'),
	  ('Centurion'),
	  ('Midrand'),
	  ('Marlboro'),
	  ('Sandton'),
	  ('Rosebank'),
	  ('Park'),
	  ('Rhodesfield'),
	  ('O.R. Tambo')
	)
  AS SOURCE ([station_name])
  ON (TARGET.[station_name] = SOURCE.[station_name])
  WHEN MATCHED THEN 
	UPDATE SET [station_name] = SOURCE.station_name, [date_updated] = CURRENT_TIMESTAMP
  WHEN NOT MATCHED BY TARGET THEN
	INSERT ([station_name], [date_created], [date_updated])
	VALUES (SOURCE.station_name, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM [Station]
GO


-- Inserting trains
MERGE [Train] AS TARGET 
USING (VALUES
	  ('Toon Express', (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Centurion'), (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Park'), '2023-07-17', '09:00:00'),
	  ('Cartoonville Chugger', (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Pretoria'), (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Rhodesfield'), '2023-07-16', '10:30:00'),
	  ('Looney Line Express', (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Centurion'), (SELECT [station_id] FROM [Station] WHERE [station_name] = 'Park'), '2023-07-17', '12:00:00')
	)
  AS SOURCE ([train_name], [source_station], [destination_station], [travel_date], [departure_time])
  ON (TARGET.train_name = SOURCE.train_name AND TARGET.source_station = SOURCE.source_station AND TARGET.destination_station = SOURCE.destination_station)
  WHEN MATCHED THEN 
	UPDATE SET [travel_date] = SOURCE.travel_date, [departure_time] = SOURCE.departure_time, [date_updated] = CURRENT_TIMESTAMP
  WHEN NOT MATCHED BY TARGET THEN
	INSERT ([train_name], [source_station], [destination_station], [travel_date], [departure_time], [date_created], [date_updated])
	VALUES (SOURCE.train_name, SOURCE.source_station, SOURCE.destination_station, SOURCE.travel_date, SOURCE.departure_time, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM [Train]
GO


-- Inserting train class types
MERGE [TrainClassType] AS TARGET 
USING (VALUES
	  ('Economy'),
	  ('Business'),
	  ('Sleeper')
	)
  AS SOURCE ([class_type_name])
  ON (TARGET.class_type_name = SOURCE.class_type_name)
  WHEN MATCHED THEN 
	UPDATE SET class_type_name = SOURCE.class_type_name, [date_updated] = CURRENT_TIMESTAMP
  WHEN NOT MATCHED BY TARGET THEN
	INSERT ([class_type_name], [date_created], [date_updated])
	VALUES (SOURCE.class_type_name, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM [TrainClassType]
GO



-- Inserting train classes
MERGE [TrainClass] AS TARGET 
USING (VALUES
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Economy'), 6, 100.30, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Toon Express')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Business'), 6, 200.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Toon Express')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Sleeper'), 6, 150.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Toon Express')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Economy'), 10, 100.30, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Cartoonville Chugger')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Business'), 10, 200.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Cartoonville Chugger')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Sleeper'), 10, 150.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Cartoonville Chugger')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Economy'), 30, 100.30, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Looney Line Express')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Business'), 30, 200.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Looney Line Express')),
		((SELECT [class_type_id] FROM [TrainClassType] WHERE [class_type_name] = 'Sleeper'), 30, 150.00, (SELECT [train_id] FROM [Train] WHERE [train_name] = 'Looney Line Express'))
	)
  AS SOURCE ([class_type_id], [capacity], [base_price],  [train_id])
  ON (TARGET.class_type_id = SOURCE.class_type_id AND TARGET.train_id = SOURCE.train_id)
  WHEN MATCHED THEN 
	UPDATE SET [capacity] = SOURCE.capacity, [base_price] = SOURCE.base_price, [date_updated] = CURRENT_TIMESTAMP
  WHEN NOT MATCHED BY TARGET THEN
	INSERT ([class_type_id], [capacity], [base_price], [train_id], [date_created], [date_updated])
	VALUES (SOURCE.class_type_id, SOURCE.capacity, SOURCE.base_price, SOURCE.train_id, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM [TrainClass]
GO


-- Inserting seat types
MERGE [SeatType] AS TARGET 
USING (VALUES
		('Window Seat'),
		('Aisle Seat'),
		('Middle Seat')
	)
  AS SOURCE ([seat_type_name])
  ON (TARGET.seat_type_name = SOURCE.seat_type_name)
  WHEN MATCHED THEN 
	UPDATE SET seat_type_name = SOURCE.seat_type_name, [date_updated] = CURRENT_TIMESTAMP
  WHEN NOT MATCHED BY TARGET THEN
	INSERT ([seat_type_name], [date_created], [date_updated])
	VALUES (SOURCE.seat_type_name, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM [SeatType]
GO


DROP PROCEDURE IF EXISTS [AddSeats];
GO

CREATE PROCEDURE [AddSeats] (
		@TrainName VARCHAR(255)
	)
AS
BEGIN
	DECLARE @train_id INT = (SELECT [train_id] FROM [Train] WHERE [train_name] = @TrainName);
	PRINT 'train_id: ' + CONVERT(VARCHAR, @train_id)

	DECLARE @CounterClass INT = 1;
	WHILE (@CounterClass <= (SELECT COUNT([class_type_id]) FROM [TrainClassType]))
	BEGIN 
		DECLARE @CounterSeat INT = 1;
		DECLARE @Counter INT = 1;
		WHILE (@Counter <= (SELECT [capacity] FROM [TrainClass] WHERE [train_id] = @train_id AND [class_type_id] = @CounterClass))
		BEGIN
			DECLARE @SeatCharNumber VARCHAR(255) = (SELECT SUBSTRING([class_type_name], 1, 1) FROM [TrainClassType] WHERE [class_type_id] = @CounterClass) + CONVERT(VARCHAR, @Counter);
			INSERT INTO [Seat] ([train_id], [class_id], [seat_type_id], [seat_number], [date_created], [date_updated])
				VALUES (@train_id, @CounterClass, @CounterSeat, @SeatCharNumber, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
			SET @Counter = @Counter + 1

			IF (@CounterSeat >= (SELECT COUNT([seat_type_id]) FROM [SeatType]))
				SET @CounterSeat = 1
			ELSE 
				SET @CounterSeat = @CounterSeat + 1
		END
		SET @CounterClass = @CounterClass + 1
	END 
END
GO


-- Inserting seats 
EXEC [AddSeats] @trainName = 'Toon Express'
EXEC [AddSeats] @trainName = 'Cartoonville Chugger'
EXEC [AddSeats] @trainName = 'Looney Line Express'

SELECT * FROM [Seat]
GO 

