'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:CompoCtrl
 * @description
 * # CompoCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('CompoCtrl', function ($scope, IngredientService, RecipeServices, ResourcesServices) {
    $scope.ingredientsImages = ResourcesServices.ingredientsImages();
    // Initialization of datas
    $scope.first = null;
    $scope.second = null;
    $scope.third = null;
    $scope.firstList = IngredientService.all();
    /**
     * Select the first ingredient.
     * @param first
     */
    $scope.selectFirst = function (first) {
      $scope.first = first;
      $scope.second = null;
      $scope.third = null;
      $scope.recipe = null;
      RecipeServices.byIngredients(first.ref).then(function (data) {
        $scope.secondList = data.map(function (item) {
          var filtered = item.ingredients.filter(function (current) {
            return current.ref != first.ref;
          });
          return {
            name: filtered[0].name,
            ref: filtered[0].ref,
            image: filtered[0].image,
            recipe: item
          };
        });
      });
    };
    /**
     * Select the second ingredient.
     * @param second
     */
    $scope.selectSecond = function (second) {
      $scope.second = second;
      $scope.third = null;

      RecipeServices.byIngredients($scope.first.ref, second.ref).then(function (data) {
        $scope.thirdList = data.map(function (item) {
          var filtered = item.ingredients.filter(function (current) {
            return current.ref != $scope.first.ref && current.ref != second.ref;
          });
          return {
            name: filtered[0].name,
            ref: filtered[0].ref,
            image: filtered[0].image,
            recipe: item
          };
        });
      });
    };
    /**
     * Select the third ingredient.
     * @param thirdRef
     */
    $scope.selectThird = function (item) {
      $scope.third = item;
    };
  });
