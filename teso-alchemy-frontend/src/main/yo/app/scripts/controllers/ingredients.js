'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:IngredientsCtrl
 * @description
 * # IngredientsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('IngredientsCtrl', function ($scope, Ingredient, Utils) {
    Ingredient.query(function (data) {
      data.forEach(function (item) {
        item.effects = item.effects.sort(Utils.sortNameAsc);
      });
      $scope.ingredients = data.sort(Utils.sortNameAsc);
    });
  });
