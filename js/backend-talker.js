const config = {
    baseURL: "http://localhost:8082",
    endpoints: {
        projectSearchName: "/projects/search/name",
        projectInsert: "/projects/insert"
    }
};



function insertProject(data) {
    const body = {
        "name": data.name,
        "teamSize": data.teamSize,
        "sponsorName": data.sponsorName,
        "description": data.description,
        "video": data.video,
        "image": data.image,
        "state": data.state,
        "courseDepartment": data.courseDepartment,
        "courseNumber": data.courseNumber,
        "year": data.year,
        "term": data.term
    }

    const params = {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify(body, null, 4)
    }

    const url = new URL(config.baseURL+config.endpoints.projectInsert);

    console.log(url, JSON.stringify(params, null, 4));

    fetch(url, params)
        .then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data.project, null, 4));
            localStorage.setItem("projectData", data.project);
            window.location.href = "projects.html";
            displayProject("project-table-output", localStorage.getItem("projectData"));
        })
}


let searchButton = document.getElementById("submitFilterButton");
if (searchButton) {
    searchButton.onclick = function() {

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
        
        fetch(url)
            .then(response => response.json())
            .then(data => {
                console.log(JSON.stringify(data.project, null, 4));
                displayProject("project-table-output", data.project);
            })
            .catch(error => alert(JSON.stringify(error.data.response, null, 4)))
    };
}


function displayProject(tagId, data) {
    let displayDiv = document.getElementById(tagId);
    console.log(data);
    displayDiv.innerHTML = formatResponse(data);
}


function formatResponse(data) {
    let tableText = `
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