'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.effectsService
 * @description
 * # effectsService
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('Effect', function ($resource) {
    return $resource('http://localhost:8080/effects/:id', {},
      {
        query: {method: 'GET', isArray: true},
      })
  });
