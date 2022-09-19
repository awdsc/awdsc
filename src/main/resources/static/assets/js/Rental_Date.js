
//페이지가 호출되면 무조건으로 호출되는 함수
window.onload = function () {
    //date 객체 생성
    var date = new Date();

    //년,월,일,시,분,초 표현
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    var day = date.getDate();
   

    
    document.querySelector('.year-month').textContent = `${year}년 ${month}월`;

    
   var dates = requestDaysPrinter(month,year);
}


//요청받은 지난달의 날짜일부와 다음달의 날짜 일부를 이번달과 합쳐 **문자배열**로 반환하는 함수
function requestDaysPrinter(month,year)
{
     //지난달과 이번달의 마지막 날짜,요일을 변수로 선언
     var prevLast = new Date(year, month - 1, 0);
     var thisLast = new Date(year, month, 0);
 
     var PLDate = prevLast.getDate();
     var PLDay = prevLast.getDay();
 
     var TLDate = thisLast.getDate();
     var TLDay = thisLast.getDay();
     //console.log(TLDate);
     var prevDates = [];
     var thisDates = [...Array(TLDate + 1).keys()].slice(1);
     var nextDates = [];
 
 
     //console.log(thisDates);
     //지난달의 날짜 채우기
     if (PLDay !== 6) {
         for (let i = 0; i < PLDay + 1; i++) {
             prevDates.unshift(PLDate - i);
         }
     }
     //다음달의 날짜 채우기
     for (let i = 1; i < 7 - TLDay; i++) {
         nextDates.push(i);
     }
 
     const dates = prevDates.concat(thisDates, nextDates);
 
     
     //console.log(dates);

     return dates;
}


//버튼 클릭시 년과 달을 이동하는 함수 2개
function onClickNextBtn()
{
    //1.현재 달에서 3개월이상 차이날시 경고 문구호출
    //2.12월 다음으로 넘어갈시 년을 바꾼다  
}

function onClickBackBtn()
{
    // 1.현재 달이전으로 넘어갈 시 경고문구 호출
    // 2. 1월에서 버튼 클릭시 년을 바꾼다
}