const options = {
    method: "POST",
    baseURL: "http://localhost:8082",
    url: "/projects/search/name",
    data: {
        "name": "191"
    }
};

const sampleData = {
    "result": {
        "code": 2020,
        "message": "Movies with the given search parameters found"
    },
    "project": {
        "id": 1,
        "name": "191 for 191",
        "teamSize": 5,
        "sponsorName": "Matthew Bietz",
        "description": "A website to share and discover past, present, and future UCI capstones projects.",
        "video": "https://www.youtube.com/watch?v=UyjVMtTk1XY&list=PLcm9UtazJCOLYIKaXcD1HVB9NGc4kuD0b&index=2",
        "image": null,
        "state": "IN_PROGRESS",
        "courseId": 36050
    }
}

const url = new URL(options.baseURL+options.url);
url.search = new URLSearchParams(options.data);

let searchButton = document.getElementById("search");   // change to id for search button
let displayDiv = document.getElementById("mypanel");    // change to div to display

searchButton.onclick = function() {
    fetch(url)
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