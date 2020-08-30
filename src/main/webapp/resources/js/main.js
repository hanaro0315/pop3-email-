$(function(){

    $(".footer .footer_layout form[name=sub]").click(function(){
    	if($("input[name=id]").val()=="23"){
    		var queryString = $("form[name=ajForm]").serialize() ;
        	
            $.ajax({
           	 url:'insert',
           	 contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type:'GET',
                data:queryString,
                success:function(data){
               	alert(queryString);
                },
                error: function(xhr, status, error){
                    alert(error);
                }
   	 
            })
    	}
      });
});