# Backend

# Endpoints

1. [POST: Insert Project](#insert-project)
2. [GET: Project Search By Name](#project-search-by-name)
3. [GET: Project Search By Id](#project-search-by-id)
4. [GET: Sponsor Search By Name](#sponsor-search-by-name)
5. [GET: Sponsor Search By Id](#sponsor-search-by-id)

## Insert Project
Inserts a project into the database

### Path
```http
POST /projects/insert
```

### API

<table>
    <tr>
    <th colspan="3" align="left">📥 Request</th>
    </tr>
	<tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
name: String
teamSize: Integer
sponsorName: String
description: String
video: String
image: String
state: String
courseId: Integer
year: Integer
term: String</pre></td>
    <td align="left"><pre lang="json">
{
    "name": "191 for 191",
    "teamSize": 5,
    "sponsorName": "Matthew Bietz",
    "description": "A website to share and discover past, present, and future UCI capstones projects.",
    "video": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
    "image": "...",
    "state": "in progress",
    "courseId": 36050,
    "year": 2022,
    "term": "spring"

}</pre></td>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="3" align="left">📤 Response</th>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
result: Result
    code: Integer
    message: String
project: Project
    id: Long
    name: String
    teamSize: Integer
    sponsorName: String
    description: String
    video: String
    image: String
    state: ProjectState
    courseId: Integer</pre></td>
    <td align="left"><pre lang="json">
{
    "result": {
        "code": 2060,
        "message": "Project registered successfully"
    },
    "project": {
        "id": 1,
        "name": "191 for 191",
        "teamSize": 5,
        "sponsorName": "Matthew Bietz",
        "description": "A website to share and discover past, present, and future UCI capstones projects.",
        "video": "https://www.youtube.com/watch?v=UyjVMtTk1XY&list=PLcm9UtazJCOLYIKaXcD1HVB9NGc4kuD0b&index=2",
        "image": "...",
        "state": "IN_PROGRESS",
        "courseId": 36050
    }
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
        <th colspan="3" align="left">📦 Results</th>
    </tr>
    <tr></tr>
    <tr>
        <th align="left" width="300">Status</th>
        <th align="left">Code</th>
        <th align="left">Message</th>
    </tr>
    <tr></tr>
    <tr>
        <td><code>✅ 200: OK</code></td>
        <td>2060</td>
        <td>Project registered successfully</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>2004</td>
        <td>Course not found</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 409: Conflict</code></td>
        <td>2061</td>
        <td>Project with this name already exists</td>
    </tr>
</table>

## Project Search By Name
Returns a movie with detailed information that contains the given <code>name</code>.

### Path
```http
GET /projects/search/name
```

### API

<table>
    <tr>
    <th colspan="3" align="left">📥 Request</th>
    </tr>
	<tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
name: String</pre></td>
    <td align="left"><pre lang="json">
{
    "name": "191 for 191"
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="3" align="left">📤 Response</th>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
result: Result
    code: Integer
    message: String
project: Project
    id: Long
    name: String
    teamSize: Integer
    sponsorName: String
    description: String
    video: String
    image: String
    state: ProjectState
    courseId: Integer</pre></td>
    <td align="left"><pre lang="json">
{
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
        "image": "...",
        "state": "IN_PROGRESS",
        "courseId": 36050
    }
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
        <th colspan="3" align="left">📦 Results</th>
    </tr>
    <tr></tr>
    <tr>
        <th align="left" width="300">Status</th>
        <th align="left">Code</th>
        <th align="left">Message</th>
    </tr>
    <tr></tr>
    <tr>
        <td><code>✅ 200: OK</code></td>
        <td>2020</td>
        <td>Movies with the given search parameters found</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>2021</td>
        <td>No movies found with the given search parameters</td>
    </tr>
</table>

## Project Search By Id
Returns a movie with detailed information that contains the given <code>id</code>.

### Path
```http
GET /projects/search/id
```

### API

<table>
    <tr>
    <th colspan="3" align="left">📥 Request</th>
    </tr>
	<tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
id: Long</pre></td>
    <td align="left"><pre lang="json">
{
    "id": 1
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="3" align="left">📤 Response</th>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
result: Result
    code: Integer
    message: String
project: Project
    id: Long
    name: String
    teamSize: Integer
    sponsorName: String
    description: String
    video: String
    image: String
    state: ProjectState
    courseId: Integer</pre></td>
    <td align="left"><pre lang="json">
{
    "result": {
        "code": 2010,
        "message": "Movie found with the specified ID"
    },
    "project": {
        "id": 1,
        "name": "191 for 191",
        "teamSize": 5,
        "sponsorName": "Matthew Bietz",
        "description": "A website to share and discover past, present, and future UCI capstones projects.",
        "video": "https://www.youtube.com/watch?v=UyjVMtTk1XY&list=PLcm9UtazJCOLYIKaXcD1HVB9NGc4kuD0b&index=2",
        "image": "...",
        "state": "IN_PROGRESS",
        "courseId": 36050
    }
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
        <th colspan="3" align="left">📦 Results</th>
    </tr>
    <tr></tr>
    <tr>
        <th align="left" width="300">Status</th>
        <th align="left">Code</th>
        <th align="left">Message</th>
    </tr>
    <tr></tr>
    <tr>
        <td><code>✅ 200: OK</code></td>
        <td>2010</td>
        <td>Movie found with the specified ID</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>2011</td>
        <td>No Movie found for the specified ID</td>
    </tr>
</table>

## Sponsor Search By Name
Returns a sponsor with basic information that contains the given <code>name</code>.

### Path
```http
GET /sponsor/search/name
```

### API

<table>
    <tr>
    <th colspan="3" align="left">📥 Request</th>
    </tr>
	<tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
name: String</pre></td>
    <td align="left"><pre lang="json">
{
    "name": "Matt"
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="3" align="left">📤 Response</th>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
result: Result
    code: Integer
    message: String
sponsor: Sponsor
    id: Long
    name: String
    website: String</pre></td>
    <td align="left"><pre lang="json">
{
    "result": {
        "code": 2050,
        "message": "Persons with the given search parameters found"
    },
    "sponsor": {
        "id": 1,
        "name": "Matthew Bietz",
        "website": "https://www..."
    }
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
        <th colspan="3" align="left">📦 Results</th>
    </tr>
    <tr></tr>
    <tr>
        <th align="left" width="300">Status</th>
        <th align="left">Code</th>
        <th align="left">Message</th>
    </tr>
    <tr></tr>
    <tr>
        <td><code>✅ 200: OK</code></td>
        <td>2050</td>
        <td>Persons with the given search parameters found</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>2051</td>
        <td>No Persons found with the given search parameters</td>
    </tr>
</table>

## Sponsor Search By Id
Returns a sponsor with basic information that contains the given <code>id</code>.

### Path
```http
GET /sponsor/search/id
```

### API

<table>
    <tr>
    <th colspan="3" align="left">📥 Request</th>
    </tr>
	<tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
id: Long</pre></td>
    <td align="left"><pre lang="json">
{
    "id": 1
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="3" align="left">📤 Response</th>
    </tr>
    <tr></tr>
    <tr>
    <th colspan="2" align="left">Model </th>
    <th align="left">Example</th>
    </tr>
    <tr>
    <td colspan="2" align="left"><pre lang="yml">
result: Result
    code: Integer
    message: String
sponsor: Sponsor
    id: Long
    name: String
    website: String</pre></td>
    <td align="left"><pre lang="json">
{
    "result": {
        "code": 2040,
        "message": "Person found with the specified ID"
    },
    "sponsor": {
        "id": 1,
        "name": "Matthew Bietz",
        "website": "https://www..."
    }
}</pre></td>
    </tr>
    <tr></tr>
    <tr>
        <th colspan="3" align="left">📦 Results</th>
    </tr>
    <tr></tr>
    <tr>
        <th align="left" width="300">Status</th>
        <th align="left">Code</th>
        <th align="left">Message</th>
    </tr>
    <tr></tr>
    <tr>
        <td><code>✅ 200: OK</code></td>
        <td>2040</td>
        <td>Person found with the specified ID</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>2041</td>
        <td>No Person found for the specified ID</td>
    </tr>
</table>