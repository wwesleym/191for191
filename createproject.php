<?php
    $title =  $_POST['title']; //2, 
    $ProjectDesc = $_POST['ProjectDesc'];//5
    $CourseName = $_POST['CourseName']; // 9
    $QuartYear = $_POST['QuartYear']; //10, 11
    $Linkss = $_POST['Linkss']; //6
    $SponsorName = $_POST['SponsorName'];//4
    $TeamMem = $_POST['TeamMem'];
    $ProjTags= $_POST['ProjTags']



    $conn = new mysqli('db.matthewbietz.org','191for191admin','Capstone22','191for191');
    if($conn->connect_error){
        echo "$conn->connect_error";
        die("Connection Failed : ". $conn->connect_error);
    } else {
        $stmt = $conn->prepare("insert into project(id, name, project_description ) values(?, ?, ?");
        $stmt->bind_param("iss", 4, $title, $ProjectDesc);
        $execval = $stmt->execute();
        echo $execval;
        echo "Registration successfully...";
        $stmt->close();
        $conn->close();
    }


?>