// CREDIT https://chrishannah.me/prntsc/
            function openInNewTab(url) {
			  var win = window.open(url, '_blank');
			  win.focus();
			}

			function openRandomImages() {
				var total = document.getElementsByName("number")[0].value;
				for (var i = 0; i < total; i++) {
					openInNewTab(generateURL());
				}
			}

			function generateURL() {
				return "https://prnt.sc/" + makeId();
			}

			function makeId() {
			   var result = '';
			   var characters  = 'abcdefghijklmnopqrstuvwxyz0123456789';
			   var charactersLength = characters.length;
			   for ( var i = 0; i < 6; i++ ) {
			      result += characters.charAt(Math.floor(Math.random() * charactersLength));
			   }
			   return result;
			}