'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:IngredientsCtrl
 * @description
 * # IngredientsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('IngredientsCtrl', function ($scope, IngredientService, ResourcesServices) {
    $scope.ingredientsImages = ResourcesServices.ingredientsImages();
    $scope.ingredients = IngredientService.all();
  }
);
