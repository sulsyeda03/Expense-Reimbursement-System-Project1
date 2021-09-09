
  console.log("Testing javascript.js file..")


  function validDate(){
      console.log("Inside validDate() function")
      var today = new Date().toISOString().split('T')[0];
document.getElementsByName("exp_date")[0].setAttribute('max', today);
}


