'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.ingredientsServices
 * @description
 * # ingredientsServices
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('RecipeServices', function (Restangular) {
    return {
      /**
       * Returns the recipe based to parameters.
       * @param id1
       * @param id2 optional
       * @returns {*}
       */
      byIngredients: function (id1, id2) {
        return Restangular.all('recipes').all('available').all('ingredients').getList(
          {
            ref1: id1,
            ref2: (typeof id2 !== 'undefined' ? id2 : '')
          }
        );
      }
    }
  });
