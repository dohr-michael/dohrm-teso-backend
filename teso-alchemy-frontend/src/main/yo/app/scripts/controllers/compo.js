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
    $scope.first = null;
    $scope.second = null;
    $scope.third = null;
    $scope.firstList = IngredientService.all();
    /**
     * Select the first ingredient.
     * @param first
     */
    $scope.selectFirst = function (item) {
      $scope.first = item;
      $scope.second = null;
      $scope.third = null;
      $scope.recipe = null;
      $scope.secondList = IngredientService.findCompatible(item.ref);
    };
    /**
     * Select the second ingredient.
     * @param second
     */
    $scope.selectSecond = function (item) {
      $scope.second = item;
      $scope.third = null;
      $scope.thirdList = IngredientService.findCompatible($scope.first.ref, item.ref);
      $scope.recipe = RecipeServices.byIngredients($scope.first.ref, item.ref);
    };
    /**
     * Select the third ingredient.
     * @param thirdRef
     */
    $scope.selectThird = function (item) {
      $scope.third = item;
      $scope.recipe = RecipeServices.byIngredients($scope.first.ref, $scope.second.ref, item.ref);
    };
  });
