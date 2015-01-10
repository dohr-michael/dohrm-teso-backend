'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:IngredientsCtrl
 * @description
 * # IngredientsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('IngredientsCtrl', function ($scope, IngredientService) {
    $scope.ingredients = IngredientService.all();
  }
);
