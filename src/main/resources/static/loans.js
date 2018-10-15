const loans = new Vue({
	el:'#loans',
	data:{
		loans:[],
		noResults:false,
		searching:false,
		resultStr:''
	},
	methods:{
		getLoans:function(borrowerId) {
			this.searching = true;
			fetch(`loansJson?borrowerId=${encodeURIComponent(borrowerId)}`)
			.then(res => res.json())
			.then(res => {
				this.searching = false;
				this.loans = res.loans;
				this.noResults = this.loans.length === 0;
			});
		}
	}
});