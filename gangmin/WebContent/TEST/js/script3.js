document.addEventListener('DOMContentLoaded', function(){
    //별점선택 이벤트 리스너
    document.querySelector('.rating').addEventListener('click',function(e){
        let elem = e.target;
        if(elem.classList.contains('rate_radio')){
            rating.setRate(parseInt(elem.value));
        }
    })

    //상품평 작성 글자수 초과 체크 이벤트 리스너
    document.querySelector('.review_textarea').addEventListener('keydown',function(){
        //리뷰 400자 초과 안되게 자동 자름
        let review = document.querySelector('.review_textarea');
        let lengthCheckEx = /^.{400,}$/;
        if(lengthCheckEx.test(review.value)){
            //400자 초과 컷
            review.value = review.value.substr(0,400);
        }
    });

    //저장 전송전 필드 체크 이벤트 리스너
    document.querySelector('#save').addEventListener('click', function(e){
        //별점 선택 안했으면 메시지 표시
        if(rating.rate == 0){
            rating.showMessage('rate');
            return false;
        }
        //리뷰 5자 미만이면 메시지 표시
        if(document.querySelector('.review_textarea').value.length < 5){
            rating.showMessage('review');
            return false;
        }
        //폼 서밋
		//실제로는 서버에 폼을 전송하고 완료 메시지가 표시되지만 저장된 것으로 간주하고 폼을 초기화 함.
		alert("저장완료!");
		rating.setRate(0);
		document.querySelector('.review_textarea').value = '';
    });
});


//별점 마킹 모듈 프로토타입으로 생성
function Rating(){};
Rating.prototype.rate = 0;
Rating.prototype.setRate = function(newrate){
    //별점 마킹 - 클릭한 별 이하 모든 별 체크 처리
    this.rate = newrate;
    document.querySelector('.ratefill').style.width = parseInt(newrate * 60) + 'px';
    let items = document.querySelectorAll('.rate_radio');
    items.forEach(function(item, idx){
        if(idx < newrate){
            item.checked = true;
        }else{
            item.checked = false;
        }
    });
}
Rating.prototype.showMessage = function(type){//경고메시지 표시
    switch(type){
        case 'rate':
            //안내메시지 표시
            document.querySelector('.review_rating .warning_msg').style.display = 'block';
            //지정된 시간 후 안내 메시지 감춤
            setTimeout(function(){
                document.querySelector('.review_rating .warning_msg').style.display = 'none';
            },1000);            
            break;
        case 'review':
            //안내메시지 표시
            document.querySelector('.review_contents .warning_msg').style.display = 'block';
            //지정된 시간 후 안내 메시지 감춤
            setTimeout(function(){
                document.querySelector('.review_contents .warning_msg').style.display = 'none';
            },1000);    
            break;
    }
}

let rating = new Rating(); //별점 인스턴스 생성

const drawStar = (target) => {
    document.querySelector(`.rating span`).style.width = `${target.value * 10}%`;
}

function revise() {
    alert('수정 혹은 삭제하시겠습니까?')
}

var comments = ["댓글1", "댓글2", "댓글3", "댓글4", "댓글5", "댓글6", "댓글7", "댓글8", "댓글9", "댓글10", "댓글11", "댓글12", "댓글13", "댓글14", "댓글15", "댓글16", "댓글17", "댓글18", "댓글19", "댓글20", "댓글21", "댓글22", "댓글23", "댓글24", "댓글25", "댓글26", "댓글27", "댓글28", "댓글29", "댓글30"];

function showComments(pageNum) {
    var startIndex = (pageNum - 1) * 10; // 시작 인덱스 계산
    var endIndex = startIndex + 9; // 끝 인덱스 계산
    if (endIndex >= comments.length) { // 마지막 페이지일 경우
        endIndex = comments.length - 1;
    }

    var commentList = document.getElementById("comment-list");
    commentList.innerHTML = ""; // 이전 페이지의 댓글 목록을 지우고

    for (var i = startIndex; i <= endIndex; i++) {
        var comment = comments[i];
        var li = document.createElement("li");
        var text = document.createTextNode(comment);
        li.appendChild(text);
        commentList.appendChild(li); // 댓글 목록에 추가
    }
}