'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.ingredientsServices
 * @description
 * # ingredientsServices
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('Ingredient', function ($resource) {
    return $resource('http://localhost:8080/ingredients/:id', {},
      {
        query: {method: 'GET', isArray: true}
      })
  });
