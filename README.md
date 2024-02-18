# Basloq 
basloq is a kotlin multi-platform project that allows you to express your thoughts in the form of quotes. The project is currently under development.

## Technologies
- Technologies implemented so far are:
  - Ktor client to make http requests
  - Preferences(It's different on every platform) to store key-value pairs. 
  - Custom Exception handling
  - managing states in the android side
  - sqldelight to caching data

  currently these feature implemented in the android platform.

## Usage 
The app uses faqvs api. to run this project you need to generate an api key and put it to this variable:
const val API_KEY = "" .

Favqs : https://favqs.com/api

## Contributing

I welcome contributions from the community! If you'd like to contribute to Basloq, please follow these guidelines:

1. Fork the repository
2. Create a new branch: `git checkout -b my-feature-branch`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin my-feature-branch`
5. Submit a pull request


## License
This project is licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

You can find a copy of the license in the [LICENSE](LICENSE) file or visit the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0) website for more details.
