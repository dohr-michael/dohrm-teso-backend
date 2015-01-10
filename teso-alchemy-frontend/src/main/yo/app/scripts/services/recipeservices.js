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
       * @param id2
       * @param id3 optional
       * @returns {*}
       */
      byIngredients: function (id1, id2, id3) {
        return Restangular.all('recipe').get('ingredients',
          {
            ref1: id1,
            ref2: id2,
            ref3: (typeof id3 !== 'undefined' ? id3 : '')
          }
        ).$object;
      }
    }
  });
