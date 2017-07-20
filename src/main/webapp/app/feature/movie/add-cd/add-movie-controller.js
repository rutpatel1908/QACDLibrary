(function() {

    var AddcdController =  function($state, cdDal) {
        var vm = this;

        vm.addcd = function(cdToAdd) {
            console.log("This is the value of cd to add " + cdToAdd);
            console.log(cdToAdd);
            var cdToJson = JSON.stringify(cdToAdd);
            console.log(cdToJson);
            cdDal.savecd(cdToAdd).then(function (results) {
                vm.cdAddMessage  = results;
                $state.go('getcd');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('cdlibrary').controller('addcdController', ['$state','cdDal',AddcdController]);
}());