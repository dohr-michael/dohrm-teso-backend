'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:CompoCtrl
 * @description
 * # CompoCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('CompoCtrl', function ($scope, IngredientService, RecipeServices) {
    // Initialization of datas
    $scope.firstRef = null;
    $scope.secondRef = null;
    $scope.thirdRef = null;
    $scope.recipe = null;
    $scope.firstList = IngredientService.all();
    /**
     * Select the first ingredient.
     * @param firstRef
     */
    $scope.selectFirst = function (firstRef) {
      $scope.firstRef = firstRef;
      $scope.secondRef = null;
      $scope.thirdRef = null;
      $scope.recipe = null;
      $scope.secondList = IngredientService.findCompatible(firstRef);
    };
    /**
     * Select the second ingredient.
     * @param secondRef
     */
    $scope.selectSecond = function (secondRef) {
      $scope.secondRef = secondRef;
      $scope.thirdRef = null;
      $scope.thirdList = IngredientService.findCompatible($scope.firstRef, secondRef);
      $scope.recipe = RecipeServices.byIngredients($scope.firstRef, secondRef);
    };
    /**
     * Select the third ingredient.
     * @param thirdRef
     */
    $scope.selectThird = function (thirdRef) {
      $scope.thirdRef = thirdRef;
      $scope.recipe = RecipeServices.byIngredients($scope.firstRef, $scope.secondRef, thirdRef);
    };
  });
