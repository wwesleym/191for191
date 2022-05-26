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
            // localStorage.setItem("projectData", data.project);
            window.location.href = "projects.html";
            // displayProject("project-table-output", localStorage.getItem("projectData"));
        })
}


function searchProjects(searchRequest) {
    const options = {
        method: "GET",
        baseURL: "http://localhost:8082",
        url: "/projects/search",
        data: {
            year: searchRequest.year,
            term: searchRequest.term,
            courseDepartment: searchRequest.courseDepartment,
            courseNumber: searchRequest.courseNumber,
        }
    };

    // remove null values
    Object.keys(options.data).forEach(key => {
        if (options.data[key] === null) {
            delete options.data[key];
        }
        });

    const url = new URL(options.baseURL+options.url);
    url.search = new URLSearchParams(options.data);
    console.log(options);
    
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // console.log(JSON.stringify(data, null, 4));
            displayProjects("project-table-output", data.projects);
        })
        // .catch(error => alert(JSON.stringify(error, null, 4)))
};



function displayProjects(tagId, projects) {
    let displayDiv = document.getElementById(tagId);
    // console.log(projects);
    displayDiv.innerHTML = formatResponse(projects);
}


function formatResponse(data) {
    console.log(data);
    let tableText = `
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Sponsor</th>
                <th>Description</th>
                <th>State</th>
                <th>Quarter</th>
                <th>Year</th>
                <th>Video</th>
            </tr>
        </thead>
        <tbody>
            ${data.map(project =>
                `<tr>
                    <td>${project.name}</td>
                    <td>${project.sponsorName}</td>
                    <td>${project.description}</td>
                    <td>${project.state}</td>
                    <td>${project.term}</td>
                    <td>${project.year}</td>
                    <td><a href="${project.video}" target='_blank'>link</a></td>
                </tr>`
            ).join('')}
        </tbody>
    </table>`;
    return tableText;
}