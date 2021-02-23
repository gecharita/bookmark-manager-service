DROP TABLE IF EXISTS bookmarks;

CREATE TABLE bookmarks (
      id INT AUTO_INCREMENT  PRIMARY KEY,
      name VARCHAR(250) NOT NULL,
      url VARCHAR(250) NOT NULL,
      category VARCHAR(250) DEFAULT NULL
);

INSERT INTO bookmarks (name, url, category) VALUES
('google', 'www.google.com', 'general'),
('dzone', 'www.dzone.com', 'tech'),
('cnn', 'www.cnn.com', 'news'),
('dw', 'www.dw.de', 'news'),
('bbc', 'www.bbc.co.uk', 'news');
