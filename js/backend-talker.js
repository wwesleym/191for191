const options = {
    method: "GET",
    baseURL: "http://localhost:8082",
    url: "/projects/search/id",  // for endpoints
    data: {
        "id": 1
    }
};

const url = new URL(options.baseURL+options.url);
url.search = new URLSearchParams(options.data).toString();

const headers = {
    "Accept": "application/json",
    "Content-Type": "application/json",
};

let searchButton = document.getElementById("search");   // change to id for search button
let displayDiv = document.getElementById("mypanel");    // change to div to display

searchButton.onclick = function() {
    console.log(url);
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data, null, 4));
            let text = "<table><thead><tr>" +
                "<th>name</th>" +
                "<th>sponsor</th>" +
                "<th>description</th>" +
                "<th>state</th>" +
                "<th>course id</th>" +
                "</tr></thead>" +
                "<tbody><tr>" +
                "<td>" + data.project.name + "</td>" +
                "<td>" + data.project.sponsorName + "</td>" +
                "<td>" + data.project.description + "</td>" +
                "<td>" + data.project.state + "</td>" +
                "<td>" + data.project.courseId + "</td>" +
                "</tr></tbody></table>";
            displayDiv.innerHTML = text;
        })
        .catch(error => {
            alert(error);
            console.error(error);
        })
};