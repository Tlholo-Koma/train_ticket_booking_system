async function fetchData() {
    try {
      const response = await fetch(""); //the api endpoint
      if (response.ok) {
        const data = await response.json();
        const recordset = data.recordset;
        const table = document.getElementById("tablebody");
  
        recordset.forEach((item) => {
          table.innerText += `<tr>
                                <td>${item.DepartureTime}</td>
                                <td>${item.TripCost}</td>
                                <td>${item.PeakType}</td>
                              </tr>`;
        });
      } else {
        console.log("Request failed with status:", response.status);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  }
  
  fetchData();
  