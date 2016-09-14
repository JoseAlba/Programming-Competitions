//slideit function creates the slideshow for the webpage I did this by creating a loop that
// changes every 2.5s it also calls our changePicture function inorder to change the image
var step = 0;
function slideit(){
    if(step < 2)
        step++;
    else
        step = 0;

    switch(step){
        case 0: changePicture('Panama.jpg');
            break;
        case 1: changePicture('veneza.jpg');
            break;
        case 2: changePicture('peoplestreet.jpg');
            break;
        default:
            changePicture('Panama.jpg');
    }

    setTimeout("slideit()", 2500);
}
slideit();

//
function changePicture(pictureChange) {
    //the image is put into a switch statement so if the image was Panama.jpg it would go to the next image
    switch (pictureChange) {
        case "Panama.jpg":
            document.getElementById("image").style.background = "url('images/Panama.jpg')";
            break;
        case "veneza.jpg":
            document.getElementById("image").style.background = "url('images/veneza.jpg')";
            break;
        case "peoplestreet.jpg":
            document.getElementById("image").style.background = "url('images/peoplestreet.jpg')";
            break;
        default:
            document.getElementById("image").style.background = "url('images/Panama.jpg')";
    }
    //we also have to make sure the backgroundsize covers the area
    document.getElementById("image").style.backgroundSize = "cover";

}

//this function is what changes the colour of the button at the very top of the page
function validate(){
    var ddl = document.getElementById("adminstrator");
    var selectedValue = ddl.options[ddl.selectedIndex].value;

    switch(selectedValue){
        case "Webmaster": document.getElementById("colour").style.background = 'chartreuse';
            break;
        case "Business": document.getElementById("colour").style.background = 'yellow';
            break;
        default : document.getElementById("colour").style.background = 'red';
    }
}
