(function() {

    var GetcdController =  function(cdDal)
    {
        var vm = this;
        vm.test = "test";

        function init() {
            cdDal.getcds().then(function (results) {
                vm.cds  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cdlibrary').controller('getcdController', ['cdDal', GetcdController]);
}());