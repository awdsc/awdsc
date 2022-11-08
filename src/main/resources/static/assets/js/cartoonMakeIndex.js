
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
function maker(bType,sx,sy,ex,ey)
{
    let sector = document.getElementById("createCut");
    let CM = document.createElement("div");
    CM.style.position = "absolute";
    CM.style.top = sy+'px';
    CM.style.left = sx +'px';
    CM.style.width = (ex-sx)+'px';
    CM.style.height = (ey-sy)+'px';

    let img = document.createElement("img")
    img.src = "../static/assets/img/"+bType +".png";
    img.style.height = "inherit";
    img.style.width = "inherit";
    img.style.position = "fixed";
    CM.appendChild(img);
    sector.appendChild(CM);
    console.log("생성완료");
}

document.addEventListener('contextmenu',rightClick,false);
document.addEventListener('click',defaultClick,false);
document.onmousedown = saveS;
document.onmouseup = saveE;


