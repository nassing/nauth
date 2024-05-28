# nauth

## Features

- Centralized authentication and authorization platform for many apps (see: nauth-portal, livepoll)
- Handles profiles for each app and can store data as JSON
- Built on Redis and signed cookies for fast results
- Allows several sign-in methods at once (SSO, username/password, local storage and magic link)
- Portal to download or delete all collected data


## How it works 

- Users who do not have an account yet will be redirected to a page where they can create one.
- Their credentials are then sent to nauth who will return a signed cookie that contains the user encrypted data. The same thing will happen if the cookie is invalidated or expired.
- Apps that use nauth can call the nauth API to write data to the redis server.
- User data will either be:
    - directly decrypted and read from the cookie. This should be the default option as it is the fastest. With the signature, the data cannot be falsified but it might not be up to date.
    - read from the database through a redis command. Fastest option if strong data accuracy is needed.
    - read from the database through the nauth API. The java app was made for writing rather than reading data, however this can be useful if you want to limit the access to the database (or if you are too lazy to connect your app to the redis server). Not recommended because the whole point of this is speed.

To Do:
- [ ] Add a way to create user data for one app
- [ ] Automatically create metadata when data is added
- [ ] Add a way to read user data for one app
- [ ] Add a way to read all user data
- [ ] Add a way to update user data for one app
- [ ] Add a way to delete user data
- [ ] Add a way to make a data unusable by the app but keep it in the database
- [ ] Add a way to create cookies
- [ ] Add a way to sign cookies
- [ ] Add a way to encrypt cookies
- [ ] Add a way to decrypt cookies (not for nauth but for the other apps)
- [ ] Handle multiple sign-in methods
- [ ] Add a way to invalidate cookies (just write a property in the cookie)
- [ ] Add a way to chose expiration user preferences for cookies
- [ ] Handle username/password
- [ ] Handle local storage
- [ ] Handle magic link
- [ ] Handle sso
- [ ] Make the whole thing compliant with GDPR