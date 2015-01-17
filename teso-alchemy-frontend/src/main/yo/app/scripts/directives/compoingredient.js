'use strict';

/**
 * @ngdoc directive
 * @name tesoAlchemyApp.directive:compoIngredient
 * @description
 * # compoIngredient
 */
angular.module('tesoAlchemyApp')
  .directive('compoIngredient', function () {
    return {
      templateUrl: 'views/directive/compoIngredient.html',
      restrict: 'AE',
      scope: {
        /**
         * The title of the list.
         */
        title: '@',
        /**
         * List of ingredients available.
         */
        ingredients: '=',
        /**
         * Change handler.
         */
        onChange: '&'
      },
      controller: function ($scope, ResourcesServices) {
        $scope.ingredientsImages = ResourcesServices.ingredientsImages();
        $scope.current = null;
        $scope.select = function (item) {
          $scope.current = item;
          $scope.onChange({data: item});
        };
        /**
         * Listen when ingredients is changed to reset the current.
         */
        $scope.$watch('ingredients', function () {
          $scope.current = null;
        });
      }
    };
  });
