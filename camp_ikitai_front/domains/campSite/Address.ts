/* eslint-disable no-useless-constructor */
export default class Address {
    constructor(
        public zipCode = '',
        public pref = '',
        public city = '',
        public otherAddress = ''
    ) { }
}