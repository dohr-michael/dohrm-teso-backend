'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:EffectsCtrl
 * @description
 * # EffectsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .controller('EffectsCtrl', function ($scope, Effect, ResourcesServices) {
    $scope.ingredientsImages = ResourcesServices.ingredientsImages();
    $scope.effects = Effect.all();
  });
