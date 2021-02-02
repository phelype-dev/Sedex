const express = require('express');
const path = require('path');
const controleSedex = process.env.npm_package_name;
const app = express();

app.use(express.static(`${__dirname}/dist/${controleSedex}`));

app.get('/*', (req, res) => {
res.sendFile(path.join(`${__dirname}/dist/${controleSedex}/index.html`));
});

app.listen(process.env.PORT || 8080);
