
 function rightClick(event)
{
    event.preventDefault();

    let menu = document.getElementById("contextmenu");
    menu.style.display = "block";
    menu.style.top = event.pageY + 'px';
    menu.style.left = event.pageX + 'px';



}
function defaultClick(event)
{
    let menu = document.getElementById("contextmenu");
    menu.style.display = "none";
    menu.style.top = null;
    menu.style.left = null;
}

document.addEventListener('contextmenu',rightClick,false);
document.addEventListener('click',defaultClick,false);
