FROM mongo

COPY address_records.json /address_records.json
COPY address_records_persons.json /address_records_persons.json
COPY address_records_companies.json /address_records_companies.json

CMD mongoimport --host ${MONGOSERVER} --db ${DATABASE} --collection ${COLLECTION_ADDRESS} --type json --file /address_records.json --jsonArray ; mongoimport --host ${MONGOSERVER} --db ${DATABASE} --collection ${COLLECTION_ADDRESS_PERSONS} --type json --file /address_records_persons.json --jsonArray ; mongoimport --host ${MONGOSERVER} --db ${DATABASE} --collection ${COLLECTION_ADDRESS_COMPANIES} --type json --file /address_records_companies.json --jsonArray