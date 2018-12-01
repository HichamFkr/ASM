function openSlideMenu(){
  document.getElementById('side-menu').style.width = '250px';
  document.getElementById('main').style.marginLeft = '250px';
}

function closeSlideMenu(){
  document.getElementById('side-menu').style.width = '0';
  document.getElementById('main').style.marginLeft = '0';
}
function changeSchedule() {
  var selectBox = document.getElementById("selectBox");
  var selectedValue = selectBox.options[selectBox.selectedIndex].value;

  if(selectedValue === 'daily'){
    document.getElementById('daily').style.display = "flex";
    document.getElementById('weekly').style.display = "none";
  }else if(selectedValue === 'weekly' ){
    document.getElementById('daily').style.display = "none";
    document.getElementById('weekly').style.display = "block";
  }
}
function displayModules() {
  console.log('display modules');
  document.getElementById('main').style.display = "none";
  document.getElementById('myProfessors').style.display ="none";
  document.getElementById('myGroup').style.display = "none";  
  document.getElementById('myModules').style.display = "flex";
  document.getElementById('myModules').style.flexWrap = "wrap";
  document.getElementById('myModules').style.justifyContent = "space-around";
}
function displayHome() {
  console.log('display Home')
  document.getElementById('myModules').style.display = "none";
  document.getElementById('myProfessors').style.display ="none";
  document.getElementById('myGroup').style.display = "none";  
  document.getElementById('main').style.display = "block";
}
function displayProfessors() {
  console.log('display Professors');
  document.getElementById('main').style.display = "none";
  document.getElementById('myModules').style.display = "none";
  document.getElementById('myGroup').style.display = "none";
  document.getElementById('myProfessors').style.display ="flex";
}
function displayGroup() {
  console.log('display Group');
  document.getElementById('main').style.display = "none";
  document.getElementById('myModules').style.display = "none";
  document.getElementById('myProfessors').style.display ="none";
  document.getElementById('myGroup').style.display = "block";
}