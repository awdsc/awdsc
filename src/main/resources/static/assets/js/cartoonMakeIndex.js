
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
 //버블타입 결정 함수 & 변수
 let bubbleType;
function createObject(type)
{
    defaultClick();
    let cur = document.getElementById("createCut");
    cur.style.cursor = "crosshair";
    bubbleType  = type;
}


//마우스 시작위치와 끝위치 변수저장
 let sX;
let sY;
let eX;
let eY;
let objCounter = 0;

function saveS(event)
{
    let cur = document.getElementById("createCut");
    if(cur.style.cursor !== "crosshair")
    {

        return
    } else if(event.which === 3)
    {

        return
    }else {
        sX = event.pageX;
        sY = event.pageY;
    }
}
 function saveE(event)
 {
     let cur = document.getElementById("createCut");
     if(cur.style.cursor !== "crosshair")
     {

         return
     }else if(event.which === 3)
     {

         return
     } else {
         eX = event.pageX;
         eY = event.pageY;
         cur.style.cursor = "default";
         maker(bubbleType,sX,sY,eX,eY);
     }
 }


let backgreound = document.getElementById("background");
backgreound.ondragover = (e) =>{e.preventDefault();}
backgreound.ondrop = (e ) =>
{
    e.preventDefault();

    let data = e.dataTransfer.files;
    let img;

    if(data.length === 1){
        console.log(data[0].type);
        if(data[0].type.match("image.*"))
        {
            if(!document.getElementById("cartoonBackGroundImg"))
            {
                img = document.createElement("img");
                img.id = "cartoonBackGroundImg";
            }else
            {
                img =  document.getElementById("cartoonBackGroundImg")
            }

            img.src = window.URL.createObjectURL(data[0]);
            img.style.outline = "none";
            img.style.width = "100%";
            img.style.height = "100%";
            backgreound.appendChild(img);
            document.getElementById("insertHelper").style.display  ="none";
        }else
        {
            console.log("error2");
        }
    }
    else {
        console.log("error1");

    }


}

 function maker(bType,sx,sy,ex,ey)
{
    let sector = document.getElementById("createCut");
    let CM = document.createElement("div");
    CM.id = "div" +objCounter;
    CM.style.position = "relative";
    CM.style.top = sy+'px';
    CM.style.left = sx +'px';
    CM.style.width = (ex-sx)+'px';
    CM.style.height = (ey-sy)+'px';
    CM.style.zIndex = 3;
    CM.draggable = true;

    let img = document.createElement("img")
    img.src = "../static/assets/img/"+bType +".png";
    img.classList += "cimg";

    let speech = document.createElement("textarea");
    speech.innerText = "텍스트를 입력해 주세요.";
    speech.classList += "ctextarea";
    speech.focus = ()=> {speech.style.border = none;};

    CM.appendChild(speech);
    CM.appendChild(img);
    sector.appendChild(CM);


    objCounter ++;
    console.log("생성완료");
}
/*
let container = document.querySelector("draggable");
 container.addEventListener("mousedown", dragStart, false);
 container.addEventListener("mouseup", dragEnd, false);
 container.addEventListener("mousemove", drag, false);

 function dragStart(e) {
     if (e.type === "touchstart") {
         initialX = e.touches[0].clientX - xOffset;
         initialY = e.touches[0].clientY - yOffset;
     } else {
         initialX = e.clientX - xOffset;
         initialY = e.clientY - yOffset;
     }

     if (e.target === dragItem) {
         active = true;
     }
 }

 function dragEnd(e) {
     initialX = currentX;
     initialY = currentY;

     active = false;
 }

 function drag(e) {
     if (active) {

         e.preventDefault();

         if (e.type === "touchmove") {
             currentX = e.touches[0].clientX - initialX;
             currentY = e.touches[0].clientY - initialY;
         } else {
             currentX = e.clientX - initialX;
             currentY = e.clientY - initialY;
         }

         xOffset = currentX;
         yOffset = currentY;

         setTranslate(currentX, currentY, dragItem);
     }
 }
*/

document.addEventListener('contextmenu',rightClick,false);
document.addEventListener('click',defaultClick,false);


document.onmousedown = saveS;
document.onmouseup = saveE;


