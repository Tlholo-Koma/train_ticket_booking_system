USE [master]
GO

DROP DATABASE IF EXISTS [AllAboard]
GO

CREATE DATABASE [AllAboard]
GO

USE [AllAboard]
GO

CREATE TABLE [Admin] (
  [admin_id]			INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [email]				VARCHAR(255) NOT NULL,
  [created_by]			VARCHAR(255) DEFAULT 'SYSTEM',
  [date_created]		DATETIME NOT NULL,
  [date_updated]		DATETIME NOT NULL
);

CREATE TABLE [Station] (
  [station_id]			INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [station_name]		VARCHAR(255) NOT NULL,
  [created_by]			VARCHAR(255) DEFAULT 'SYSTEM',
  [date_created]		DATETIME NOT NULL,
  [date_updated]		DATETIME NOT NULL
);

CREATE TABLE [Train] (
  [train_id]			INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [train_name]			VARCHAR(255) NOT NULL,
  [source_station]		INT NOT NULL,
  [destination_station] INT NOT NULL,
  [travel_date]			DATE NOT NULL,
  [departure_time]		TIME NOT NULL,
  [created_by]			VARCHAR(255) DEFAULT 'SYSTEM',
  [date_created]		DATETIME NOT NULL,
  [date_updated]		DATETIME NOT NULL,
  FOREIGN KEY ([source_station]) REFERENCES [Station]([station_id]),
  FOREIGN KEY ([destination_station]) REFERENCES [Station]([station_id])
);

CREATE TABLE [PeakTimes] (
  [peak_time_id]				INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [start_time]					TIME NOT NULL,
  [end_time]					TIME NOT NULL,
  [price_increase_percentage]	FLOAT NOT NULL,
  [created_by]					VARCHAR(255) DEFAULT 'SYSTEM',
  [date_crated]					DATETIME NOT NULL,
  [date_updated]				DATETIME NOT NULL
)

CREATE TABLE [TrainClassType] (
  [class_type_id]	INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [class_type_name] VARCHAR(255) NOT NULL,
  [created_by]		VARCHAR(255) DEFAULT 'SYSTEM',
  [date_created]	DATETIME NOT NULL,
  [date_updated]	DATETIME NOT NULL
);

CREATE TABLE [TrainClass] (
  [class_id]		INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [train_id]		INT NOT NULL,
  [class_type_id]	INT NOT NULL,
  [capacity]		INT NOT NULL,
  [base_price]		DECIMAL(19,2) NOT NULL,
  [date_created]	DATETIME NOT NULL,
  [date_updated]	DATETIME NOT NULL,
  FOREIGN KEY ([train_id]) REFERENCES [Train]([train_id]),
  FOREIGN KEY ([class_type_id]) REFERENCES TrainClassType ([class_type_id])
);

CREATE TABLE [SeatType] (
  [seat_type_id]	INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [seat_type_name]	VARCHAR(255) NOT NULL,
  [created_by]		VARCHAR(255) DEFAULT 'SYSTEM',
  [date_created]	DATETIME NOT NULL,
  [date_updated]	DATETIME NOT NULL
);

CREATE TABLE [Seat] (
  [seat_id]			INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [train_id]		INT NOT NULL,
  [class_id]		INT NOT NULL,
  [seat_type_id]	INT NOT NULL,
  [seat_number]		VARCHAR(255) NOT NULL,
  [is_booked]		BIT DEFAULT 0 NOT NULL,
  [date_created]	DATETIME NOT NULL,
  [date_updated]	DATETIME NOT NULL,
  FOREIGN KEY ([train_id]) REFERENCES Train([train_id]),
  FOREIGN KEY ([class_id]) REFERENCES TrainClass([class_id]),
  FOREIGN KEY ([seat_type_id]) REFERENCES SeatType([seat_type_id])
);

CREATE TABLE [Booking] (
  [booking_id]			INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [train_id]			INT NOT NULL,
  [user_email]			VARCHAR(255) NOT NULL,
  [booking_date]		DATETIME NOT NULL,
  [ticket_price]		DECIMAL(19,2) NOT NULL,
  [date_created]		DATETIME NOT NULL,
  [date_updated]		DATETIME NOT NULL,
  FOREIGN KEY ([train_id]) REFERENCES Train([train_id]),
);

CREATE TABLE [Passenger] (
  [passenger_id]		INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  [booking_id]			INT NOT NULL,
  [seat_id]				INT NOT NULL,
  [passenger_name]		VARCHAR(255) NOT NULL,
  [age]					INT NOT NULL,
  [date_created]		DATETIME NOT NULL,
  [date_updated]		DATETIME NOT NULL,
  FOREIGN KEY ([booking_id]) REFERENCES Booking([booking_id]),
  FOREIGN KEY ([seat_id]) REFERENCES Seat([seat_id])
);
