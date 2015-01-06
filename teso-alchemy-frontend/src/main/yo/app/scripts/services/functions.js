'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:EffectsCtrl
 * @description
 * # EffectsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .factory('Utils', function () {
    return {
      sortNameAsc: function (a, b) {
        if (a.name['fr'] < b.name['fr']) return -1;
        if (a.name['fr'] > b.name['fr']) return 1;
        return 0;
      }
    }
  });
