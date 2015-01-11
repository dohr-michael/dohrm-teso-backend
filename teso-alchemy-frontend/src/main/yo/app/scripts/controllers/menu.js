'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('MenuCtrl', function ($scope, $location) {
    $scope.isActive = function (route) {
      var currentPath = $location.path();
      return route === currentPath || currentPath.indexOf(route) == 0;
    };
  });
