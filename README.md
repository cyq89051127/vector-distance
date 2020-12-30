This project helps compute vector distance when using es for a similarity computing within image search or other scenarios
In this project, you can compute the distance between vectors using Cosine-Distance or Eulidean-Distance.


Method to config distance computer :

    set computer to cosine or eulidean, the default value is eulidean
    {
            "from": 0,
            "size": 3,
            "_source": {
                "excludes": ""
            },
            "sort": {
                "_score": {
                    "order": "asc"
                }
            },
            "query": {
                "function_score": {
                    "query": {
                        "match_all": {}
                    },
                    "functions": [
                        {
                            "script_score": {
                                "script": {
                                    "source": "image_source",
                                    "lang": "similarity_image",
                                    "params": {
                                        "computer": "cosine",
                                        "field": "feature",
                                        "feature": feature_list
                                    }
                                }
                            }
                        }
                    ]
                }
            }
        }
Steps to install the plugin:

    1. Copy the SimilartiyComputer-plugin.zip to a  Elastic Search 
    2. Using bin/elasticesearch-plugin install file:///path/to/Similarity-plugin.zip
    
Steps to uninstall the plugin :

    1. Using bin/elasticesearch-plugin remove SimilartiyComputer