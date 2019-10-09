# city 
s/<orgname>/City of Gainsville, Florida/g

# license
s/([A-Z]{2})DL [0-9]{6,}/\1DL XXXXXX/g

# bank
s/5[0-9]{3}-[0-9]{4}-[0-9]{4}/MC/g
s/3[4|7][0-9]{2}-{0,1}[0-9]{6}-[0-9]/AMEX-/g
s/6[0-9]{3}-[0-9]{4}-[0-9]{4}/DISC/g
s/4[0-9]{11}/VISA-/g

# plate 
s/TX [A-Z]{3}-?[0-9]{4}/TX XXXXXX/g
s/TX [A-Z0-9]{3}-?[A-Z0-9]{3}/TX XXXXXX/g