<?php

//id = random number for id that checks
//name = title
//team_size = number of student objects in the group start at 0
//sponsor_id = basically the sponsor object NULL for now random number for id that checks
//project_description = project description
//pitch_video = links
//image = links? NULL for now
//state = 1 = notstart, 2 = inprogress, 3 = complete 
//course_instance_id = the course code like 31483
//year = year number
//term = 1 = fall, 2 = winter, 3 = spring, 4 = summer


    $fillerId = random_int(0,999);
    $title =  $_POST['title'];  
    $fillerTeamSize = 0;
    $fillerSponsorId = 1;    
    $ProjectDesc = $_POST['ProjectDesc'];
    $Linkss = $_POST['Linkss']; 
    $fillerImage = NULL;
    $fillerState = 1; // will always be 1 because creation has happened unless team size is increased but so far we can't do that
    $courseCode = NULL; //filler
    //$courseCode = $_POST['courseCode'];
    $yearInput = $_POST['yearInput']; // 9
    $quarterInput = $_POST['quarterInput']; //also term



    //$conn = new mysqli('db.matthewbietz.org','191for191admin','Capstone22','191for191');
    //add some random number generator to make the id and check that id if it already exists.
    //sponsor ids should be whateber

    $conn = new mysqli('localhost','root','','191for191');
    if($conn->connect_error){
        echo "$conn->connect_error";
        die("Connection Failed : ". $conn->connect_error);
    } else {


        if ($quarterInput = 1) {
            $quarterInput = "FALL";
          } elseif ($quarterInput = 2) {
            $quarterInput = "WINTER";
          } elseif ($quarterInput = 3) {
            $quarterInput = "SPRING";
          } else {
            $quarterInput = "SUMMER";
          }

        if ($fillerState = 1) {
            $fillerState = "NOT_STARTED";
          } elseif ($fillerState = 2) {
            $fillerState = "IN_PROGRESS";
          } else {
            $fillerState = "COMPLETED";
          } 


        $stmt = $conn->prepare("insert into project(id, name, team_size, sponsor_id, project_description, pitch_video, image,state, course_instance_id, year, term) values(?,?,?,?,?,?,?,?,?,?,?)");
        $stmt->bind_param("isiissssiis", $fillerId, $title,  $fillerTeamSize, $fillerSponsorId, $ProjectDesc,  $Linkss, $fillerImage, $fillerState, $courseCode,  $yearInput, $quarterInput);
        $execval = $stmt->execute();
        echo $execval;
        echo "Registration successfully...";
        $stmt->close();
        $conn->close();
    }


?>