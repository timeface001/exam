$('.dropdown-toggle').dropdown();//初始化下拉彩单
$(function () {
  $('[data-toggle="tooltip"]').tooltip();//初始化提示框
});

	function jumpNext(){
	 self.location='item-list.htm';//跳转
	}
	function bacf(){
		self.location='item-knows.htm';//跳转
	}
	function jumponlinetest(){
		self.location='onlinetest.htm';//跳转
	}
	$("div.btn-my").mousedown(function(){
		$(this).css("box-shadow","none");
	});
		$("div.btn-my").mouseup(function(){
		$(this).css("box-shadow","0px 0px 6px #122B40");
	});

