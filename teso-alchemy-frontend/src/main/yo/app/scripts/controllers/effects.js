'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:EffectsCtrl
 * @description
 * # EffectsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('EffectsCtrl', function ($scope, Effect, Utils) {
    Effect.query(function (data) {
      data.forEach(function (item) {
        item.ingredients = item.ingredients.sort(Utils.sortNameAsc);
      });
      $scope.effects = data.sort(Utils.sortNameAsc);
    });
  });
