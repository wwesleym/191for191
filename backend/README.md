# Backend

# Endpoints

## Project Search
Returns a movie with detailed information that contains the given <code>name</code>.

### Path
```http
POST /sample/search
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
    id: Integer
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
        "code": 1026,
        "message": "Project successfully found"
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
        <td>1026</td>
        <td>Project successfully found</td>
    </tr>
    <tr></tr>
    <tr>
        <td><code>❗ 401: Unauthorized</code></td>
        <td>1027</td>
        <td>Project not found</td>
    </tr>
</table>