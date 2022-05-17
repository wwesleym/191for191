const options = {
    method: "POST",
    baseURL: "http://localhost:8082",
    url: "/sample/search",  // for endpoints
    data: { // where to set parameters for each endpoint
        "name": "191"
    }
};

const url = new URL(options.baseURL+options.url);

const headers = {
    "Accept": "application/json",
    "Content-Type": "application/json",
};

let searchButton = document.getElementById("search");   // change to id for search button
let displayDiv = document.getElementById("mypanel");    // change to div to display

searchButton.onclick = function() {
    // console.log(headers);
    fetch(url.toString(), {
        method: "POST",
        headers: headers,
        body: JSON.stringify(options.data)
    })
        .then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data.project, null, 4));
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
};