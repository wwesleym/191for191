const options = {
    method: "GET",
    baseURL: "http://localhost:8082",
    url: "/projects/search/name",
    data: {
        "name": "191"
    }
};

const url = new URL(options.baseURL+options.url);
url.search = new URLSearchParams(options.data);

let searchButton = document.getElementById("submitFilterButton");
let displayDiv = document.getElementById("project-table-output");

searchButton.onclick = function() {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data.project, null, 4));
            displayDiv.innerHTML = formatResponse(data.project);
        })
};

function formatResponse(data) {
    let tableText = "";
    tableText += `
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Sponsor</th>
                <th>Description</th>
                <th>State</th>
                <th>Course id</th>
                <th>Video</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${data.name}</td>
                <td>${data.sponsorName}</td>
                <td>${data.description}</td>
                <td>${data.state}</td>
                <td>${data.courseId}</td>
                <td><a href="${data.video}" target='_blank'>link</a></td>
            </tr>
        </tbody>
    </table>`;
    return tableText;
}