'use strict';

describe('Service: effectsService', function () {

  // load the service's module
  beforeEach(module('tesoAlchemyApp'));

  // instantiate service
  var effectsService;
  beforeEach(inject(function (_effectsService_) {
    effectsService = _effectsService_;
  }));

  it('should do something', function () {
    expect(!!effectsService).toBe(true);
  });

});
