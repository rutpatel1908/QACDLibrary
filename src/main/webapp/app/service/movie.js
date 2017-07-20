"use strict";

(function () {

    angular.module("cdlibrary").service("cdDal", ["dal", cdDal]);

    function cdDal (dal) {

        this.getcds = function () {
            return dal.http.GET("rest/cdlibrary/json");
        };

        this.savecd = function (cdToSave) {
            return dal.http.POST("rest/cdlibrary/json", cdToSave);
        };

        this.updatecd = function (cdToUpdate) {
            return dal.http.PUT("rest/cdlibrary/json/", cdToUpdate);
        };

        this.deletecd = function (cdToDelete) {
            return dal.http.DELETE("rest/cdlibrary/json/", cdToDelete);
        };

    }
}());
