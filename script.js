// Sample employee data
const employees = [
    { id: 1, name: "John Doe", department: "IT", skillLevel: 3 },
    { id: 2, name: "Jane Smith", department: "HR", skillLevel: 2 },
    { id: 3, name: "Michael Johnson", department: "Finance", skillLevel: 4 },
    { id: 4, name: "Emily Brown", department: "Marketing", skillLevel: 2 }
  // ... add more employee objects here
];

// Function to populate the employee table
function populateTable() {
    const table = document.getElementById('employee-table');

    // Loop through employees and create table rows
    employees.forEach(employee => {
        const row = table.insertRow();
        row.insertCell(0).textContent = employee.id;
        row.insertCell(1).textContent = employee.name;
        row.insertCell(2).textContent = employee.department;
        row.insertCell(3).textContent = employee.skillLevel;
    });
}

// Function to create a skill level graph
function createGraph() {
    const canvas = document.getElementById('skill-graph');
    const ctx = canvas.getContext('2d');

    // Use Chart.js to create a bar chart
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: employees.map(employee => employee.name),
            datasets: [{
                label: 'Skill Level',
                data: employees.map(employee => employee.skillLevel),
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

// Call functions to populate table and create graph
populateTable();
createGraph();
