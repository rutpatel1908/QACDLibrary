(function() {

    var DashBoardController =  function()
    {
        var vm = this;

        vm.test = "test";
    };
    angular.module('cdlibrary').controller('dashboardController', [DashBoardController]);
}());